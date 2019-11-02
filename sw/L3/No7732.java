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
			Date nowTime = timeFmt.parse(br.readLine()); //SimpleDateFormat에 지정된 형식 문자열을 Date타입 ex) Thu Jan 01 23:59:59 KST 1970
			Date meetTime = timeFmt.parse(br.readLine()); // miliSecond를 구하기 위해 Date형식으로 변형
			//시간 비교를 위한 밀리세컨드 변환
			long miliNow = nowTime.getTime(); //Date형식은 long 타입의 밀리세컨드를 보여줌, 문자열들을 계산 하기 힘들기에 밀리 세컨드로 변화시켜 시간이나 날짜 차이들을 구할 수 있다
			long miliMeet = meetTime.getTime();
			System.out.println("nowmili: "+miliNow); //1시부터 10시까지는 -로 나옴
			System.out.println("meetmili: "+miliMeet);
			
			System.out.print("#"+(i+1)+" ");
			//현재시간이 약속시간 보다 빠른 일반적인 경우
			//if( miliNow < miliMeet ) {

				long leftTime = miliMeet - miliNow ;
				String timeGmt9 = timeFmt.format(new Date(leftTime));  //Date(밀리세컨드)는 Date타입으로 ,simpleFormat.format() Date 타입을 지정된 문자열 타입으로
				String[] time = timeGmt9.split(":");
				int gmtHour2Hour = Integer.parseInt(time[0]) - 9; // gmt차이 때문에 9시간의 차이가남 이것을 해결하기위해
				if( gmtHour2Hour < 0) {
					gmtHour2Hour = gmtHour2Hour +24; //시간은 0-23으로 문제에서 지정되기에 -가 생길 경우가 있음 이때 24를 더해주면 옳은 값, 차이가 8:00:00이면 gmt때문에 -9를 하면 -1인데 이것은 -1이아니라 23을 나타내야함
				}
				time[0] = String.valueOf(gmtHour2Hour);
				System.out.println(timeFmt.format(timeFmt.parse(time[0]+":"+time[1]+":"+time[2])));
				
				
				/*
				밀리세컨드를 시간으로 변환시키는 식
				long leftTime = (miliMeet - miliNow) / 1000;
				long sec = leftTime % 60 ;
				long min = (leftTime/60) % 60;  //%하기전은 분으로 변환, %60은 해당 분을 HH:mm:ss로 나타낼 때 어차피 시간과 초도 나타나기에 필요한 분만 추출하는 것
				long hour = leftTime / (60*60);
				System.out.println(sec);
				System.out.println(min);
				System.out.println(hour);
				*/			
			}
		}
	}
//}