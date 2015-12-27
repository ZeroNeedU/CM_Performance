package xingneng.test;

import java.io.IOException;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class startTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Timer time=new Timer();
        RunShellTools run=new RunShellTools();
		time.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
		        try {
					run.RunShell("adb shell dumpsys meminfo com.cleanmaster.mguard","com.cleanmaster.mguard");
			        run.RunShell("adb shell dumpsys meminfo com.cleanmaster.mguard:service","com.cleanmaster.mguard:service");
			        run.RunShell("adb shell dumpsys meminfo com.cleanmaster.mguard:worker","com.cleanmaster.mguard:worker");
			        System.out.println("===================================================");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}, 1000,30000);
	}

}
