package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
public class LogDemoService {

  private final ObjectProvider<MyLogger> myLoggerObjectProvider;

  public LogDemoService(
      ObjectProvider<MyLogger> myLoggerObjectProvider) {
    this.myLoggerObjectProvider = myLoggerObjectProvider;
  }


  public void logic(String test_id) {
    MyLogger myLogger = myLoggerObjectProvider.getObject();
    System.out.println(myLogger + "mylogger print service");
    myLogger.log("service id = " + test_id);
  }
}
