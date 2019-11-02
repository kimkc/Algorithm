package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class No7732 {

	public static void main(String[] args) throws IOException, ParseException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCaseNum; i++) {

			SimpleDateFormat timeFmt = new SimpleDateFormat("HH:mm:ss");
			Date nowTime = timeFmt.parse(br.readLine()); //SimpleDateFormat�� ������ ���� ���ڿ��� DateŸ�� ex) Thu Jan 01 23:59:59 KST 1970
			Date meetTime = timeFmt.parse(br.readLine()); // miliSecond�� ���ϱ� ���� Date�������� ����
			//�ð� �񱳸� ���� �и������� ��ȯ
			long miliNow = nowTime.getTime(); //Date������ long Ÿ���� �и������带 ������, ���ڿ����� ��� �ϱ� ����⿡ �и� ������� ��ȭ���� �ð��̳� ��¥ ���̵��� ���� �� �ִ�
			long miliMeet = meetTime.getTime();
			System.out.println("nowmili: "+miliNow); //1�ú��� 10�ñ����� -�� ����
			System.out.println("meetmili: "+miliMeet);
			
			System.out.print("#"+(i+1)+" ");
			//����ð��� ��ӽð� ���� ���� �Ϲ����� ���
			//if( miliNow < miliMeet ) {

				long leftTime = miliMeet - miliNow ;
				String timeGmt9 = timeFmt.format(new Date(leftTime));  //Date(�и�������)�� DateŸ������ ,simpleFormat.format() Date Ÿ���� ������ ���ڿ� Ÿ������
				String[] time = timeGmt9.split(":");
				int gmtHour2Hour = Integer.parseInt(time[0]) - 9; // gmt���� ������ 9�ð��� ���̰��� �̰��� �ذ��ϱ�����
				if( gmtHour2Hour < 0) {
					gmtHour2Hour = gmtHour2Hour +24; //�ð��� 0-23���� �������� �����Ǳ⿡ -�� ���� ��찡 ���� �̶� 24�� �����ָ� ���� ��, ���̰� 8:00:00�̸� gmt������ -9�� �ϸ� -1�ε� �̰��� -1�̾ƴ϶� 23�� ��Ÿ������
				}
				time[0] = String.valueOf(gmtHour2Hour);
				System.out.println(timeFmt.format(timeFmt.parse(time[0]+":"+time[1]+":"+time[2])));
				
				
				/*
				�и������带 �ð����� ��ȯ��Ű�� ��
				long leftTime = (miliMeet - miliNow) / 1000;
				long sec = leftTime % 60 ;
				long min = (leftTime/60) % 60;  //%�ϱ����� ������ ��ȯ, %60�� �ش� ���� HH:mm:ss�� ��Ÿ�� �� ������ �ð��� �ʵ� ��Ÿ���⿡ �ʿ��� �и� �����ϴ� ��
				long hour = leftTime / (60*60);
				System.out.println(sec);
				System.out.println(min);
				System.out.println(hour);
				*/			
			}
		}
	}
//}