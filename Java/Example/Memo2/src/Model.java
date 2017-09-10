import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class Model {
	
	private final String COLUM_SEP ="::";
	
	private final String DB_DIR = "D:\\workspaces\\java\\database";//������� ������ ������, ���� ������ ������ ////<- ����
	private final String DB_FILE = "memo.txt"; ////<- ����
	private final String DB_FILE_INDEX = "Index.txt";
	
	private File database = null;
	private File indexDatabase = null;
	
	// ��ü �޸� �����ϴ� �����
	// �������� ��ü�� �����ϴ� list�� �ȴ�.
	ArrayList<Memo> list = new ArrayList<>();
	
	//������
	public Model() {
		File dir = new File(DB_DIR);
		// ���丮 ��������
		if(!dir.exists()) {
			dir.mkdirs(); 
		}
		File file = new File(DB_DIR + File.separator + DB_FILE);
		File fileIndex = new File(DB_DIR + File.separator + DB_FILE_INDEX);
		
		//������ �������� �ľ�
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(!fileIndex.exists()) {
			try {
				fileIndex.createNewFile();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		database = file;
		indexDatabase = fileIndex;
	}
	
	public void create(Memo memo) {
		
		//�۹�ȣ �ҷ�����
		memo.no = showIndex()+1;
		
		FileOutputStream fos =null;
		try {
			// ������ ������ �����ڷ� �и��Ͽ� ������ ���ڿ��� �ٲ۴�.
			String row = memo.no + COLUM_SEP 
					+ memo.name + COLUM_SEP 
					+ memo.content + COLUM_SEP 
					+ memo.datetime + "\n";
			
			// 1. ���� ��Ʈ�� Ȱ�� (Output ��Ʈ��)
			fos = new FileOutputStream(database, true);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.append(row);
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //������ ����
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//read
	public Memo read(int no) {
		
		list.clear();
		showList();
			
		// no�� �´� memo ã��
		for(Memo memo : list) {
			if(memo.no == no) {
				
				return memo;
			}
		}
		return null;
	}
	
	//update
	public boolean update(int no, Memo memoTemp) {		
		boolean check=false;
		boolean checkTemp = false;
		//�۹�ȣ�� �޾� Ư�� memo Search
		
		list.clear();
		showList();
		
		String row="";
		for(Memo memo : list) {
			if(memo.no == no) {
				memo.name = memoTemp.name;
				memo.content = memoTemp.content;
				checkTemp=true;
			}
			
			row = row
				+ memo.no + COLUM_SEP 
				+ memo.name + COLUM_SEP 
				+ memo.content + COLUM_SEP 
				+ memo.datetime + "\n";
		}		
		
		FileOutputStream fos =null;
		try {
						
			// ���� ��Ʈ�� (Output ��Ʈ��)
			fos = new FileOutputStream(database, false);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.append(row);
			bw.flush();
			if(checkTemp==true) {
				check = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return check;
	}
	
	//delete
	public boolean delete(int no) {
		boolean check = false;
		boolean checkTemp = false;
		
		list.clear();
		showList();
		
		String row = "";
		Iterator<Memo> iter = list.iterator();
		while(iter.hasNext()) {
			Memo memo = iter.next();
			
			if(memo.no == no) {
				checkTemp = true;
			} else {
				row = row
						+ memo.no + COLUM_SEP 
						+ memo.name + COLUM_SEP 
						+ memo.content + COLUM_SEP 
						+ memo.datetime + "\n";
			}			
		}
		
		FileOutputStream fos =null;
		try {
			//���� ��Ʈ�� Ȱ�� (Output ��Ʈ��)
			fos = new FileOutputStream(database, false);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.append(row);
			bw.flush();
			if(checkTemp==true) {
				check = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return check;
	}
	
	// ����� ������ 
	public ArrayList<Memo> showList(){
		
		// �����Ͱ� �ߺ��ؼ� ������ �ʵ��� ����Ҹ� �����ִ� �۾��� �ʿ��� ��찡 �ִ�.
		list.clear();
		
		// �д� ��Ʈ�� Ȱ��
		try(FileInputStream fis = new FileInputStream(database)){
			InputStreamReader isr = new InputStreamReader(fis, "MS949");
			BufferedReader br = new BufferedReader(isr);
			
			String row;
			while( (row = br.readLine()) != null ) { 
				String tempRow[] = row.split(COLUM_SEP);
				Memo memo = new Memo();
				memo.no = Integer.parseInt(tempRow[0]);
				memo.name = tempRow[1];
				memo.content = tempRow[2];
				memo.datetime = Long.parseLong(tempRow[3]);
				
				list.add(memo);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return list;
	}
	
	public int showIndex() {
		int index=0 ; 
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(indexDatabase);
			InputStreamReader isr = new InputStreamReader(fis,"MS949");
			BufferedReader br = new BufferedReader(isr);
			String row;
			
			while((row = br.readLine()) != null) {
				index = Integer.parseInt(row);
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return index;
	}

}