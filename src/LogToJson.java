import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

public class LogToJson {
	
	public static void main(String[] args) {
		File file = new File("promotion1.log");
		Gson gson = new Gson();
		String text = "";
		int count = 0;
		ArrayList<PhoneLog> phoneLogList = new ArrayList<>();
		ArrayList<SmallLog>showList = new ArrayList<>();
		try {
			FileInputStream fp = new FileInputStream(file);
			BufferedReader bf = new BufferedReader(new InputStreamReader(fp));
			String line;
			try {
				while((line = bf.readLine())!= null) {
					System.out.println(line);
					line = line.replace("|", "<<");
					String[] lineBuffer = line.split("<<");
					System.out.println(lineBuffer.length);
					PhoneLog log = new PhoneLog(lineBuffer[0],lineBuffer[1],lineBuffer[2],lineBuffer[3],lineBuffer[4]);
					log.calculateCallingTime();
					phoneLogList.add(log);
					showList.add(new SmallLog(log.getPhoneNumber(),log.getCallFee(),(int)log.getCallingTime()));
				}
				fp.close();
				FileWriter fw = new FileWriter("callingFee.json");
				String json = new Gson().toJson(showList);
				fw.write(json);
				fw.flush();
				System.out.println(json);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
