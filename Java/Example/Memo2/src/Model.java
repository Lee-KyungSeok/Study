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
	// ���� ������ ����
	private final String COLUM_SEP ="::";
	
	private final String DB_DIR = "C:\\workspaces\\java\\Memo2\\database";//������� ������ ������, ���� ������ ������
	private final String DB_FILE = "memo.txt";
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
	
	// rowSum : �޸� ������  �޾� row ���·� ��ȯ
	public String rowSum(Memo memo) {
		String row;
		row =  memo.no + COLUM_SEP 
				+ memo.name + COLUM_SEP 
				+ memo.content + COLUM_SEP 
				+ memo.datetime + "\n";
		return row;
	}
	
	//savingMemo : �޸� ������ �޾� ���Ͽ� ����
	public boolean savingMemo(File file, boolean adding, String contents) {
		boolean check = false;
		// ��½�Ʈ�� Ȱ��
		FileOutputStream fos = null;
		try {
			// ��Ʈ���� ���� -> ��Ʈ�� �߰� ó�� -> ����ó��
			fos = new FileOutputStream(file, adding);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.append(contents);
			bw.flush();
			check = true;
			
		} catch(Exception e){
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
	
	// loadingMemo : �޸��忡 ����� ������ List�� �ҷ���
	public ArrayList<String> loadingMemo(File file) {
		ArrayList<String> rowContent = new ArrayList<>();
		
		// ��Ʈ���� ���� -> ��Ʈ�� �߰� ó�� -> ����ó��
		try(FileInputStream fis = new FileInputStream(file)){
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String row;
			
			while((row = br.readLine()) != null) {
				rowContent.add(row);
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return rowContent;
	}
	
	//showIndex : �������� ����� index�� �ҷ���
	public int showIndex() {
		int index=0 ; 
		
		// ����� index�� load
		ArrayList<String> indexList = loadingMemo(indexDatabase);
		
		// �������� ����� index�� �ҷ���
		for(String row : indexList) {
			index = Integer.parseInt(row);
		}
		return index;
	}
	
	// showList : ����� ������ 
	public ArrayList<Memo> showList(){
		
		// �����Ͱ� �ߺ��ؼ� ������ �ʵ��� ����Ҹ� �����ִ� �۾��� �ʿ��� ��찡 �ִ�.
		list.clear();
		
		//row ���� ������ list�� �ҷ��´�
		ArrayList<String> rowList = loadingMemo(database);
		
		// list�� memo��ü�� �°� �޸𸮿� �����Ѵ�.
		for(String row : rowList) {
			String tempRow[] = row.split(COLUM_SEP);
			Memo memo = new Memo();
			memo.no = Integer.parseInt(tempRow[0]);
			memo.name = tempRow[1];
			memo.content = tempRow[2];
			memo.datetime = Long.parseLong(tempRow[3]);

			list.add(memo);	
		}
		return list;
	}
	
	// create
	public void create(Memo memo) {
		
		//�۹�ȣ �ҷ�����
		memo.no = showIndex()+1;
		
		// ������ ������ �����ڷ� �и��Ͽ� ������ ���ڿ��� �ٲ۴�.
		String row = rowSum(memo);
		// ��ü �޸��忡 �޸� ����
		savingMemo(database, true, row);
		
		//������ �ε����� ����
		String indexString = Integer.toString(memo.no)+"\n";
		// index �޸��忡 �ε��� ����
		savingMemo(indexDatabase, true, indexString);
	}
	
	//read
	public Memo read(int no) {
		
		//�޸� ����Ʈ �ʱ�ȭ �� �޸������κ��� �ҷ���
		list.clear();
		showList();
		
		// no�� �´� memo ã��
		for(Memo memo : list) {
			if(memo.no == no) {
				return memo;
			}
		}
		// ã�� memo�� ���� ��� null�� ��ȯ
		return null;
	}
	
	//update
	public boolean update(int no, Memo memoTemp) {		
		boolean check=false;
		boolean checkTemp = false;
		boolean checkInput = false;
		
		// �޸� ����Ʈ �ʱ�ȭ �� �޸������κ��� �ҷ���
		list.clear();
		showList();
		
		// No�� �´� �޸� ã�� ����
		String row="";
		for(Memo memo : list) {
			if(memo.no == no) {
				memo.name = memoTemp.name;
				memo.content = memoTemp.content;
				checkTemp=true;
			}
			//row�� ���� �߰�
			row = row +rowSum(memo);
		}
		// ��ü �޸��忡 �޸� ����
		checkInput = savingMemo(database, false, row);
		
		// ���� �Ϸ���� üũ
		if(checkTemp==true && checkInput==true) {
			check = true;
		}
		return check;
	}
	
	//delete
	public boolean delete(int no) {
		boolean check = false;
		boolean checkTemp = false;
		boolean checkInput = false;
		
		// �޸� ����Ʈ �ʱ�ȭ �� �޸������κ��� �ҷ���
		list.clear();
		showList();
		
		// No�� �´� �޸� ã�� ����
		String row = "";
		Iterator<Memo> iter = list.iterator();
		while(iter.hasNext()) {
			Memo memo = iter.next();
			
			// ������ memo ���� �����ϰ� row�� ��� memo�� �߰�
			if(memo.no == no) {
				checkTemp = true;
			} else {
				row = row +rowSum(memo);
			}			
		}
		// ��ü �޸��忡 �޸� ����
		checkInput = savingMemo(database, false, row);
		
		// ���� �Ϸ���� üũ
		if(checkTemp==true && checkInput) {
			check = true;
		}
		return check;
	}
}