package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
  private final MyLogger myLogger;

  public void logic(String test_id) {
    System.out.println(myLogger + "mylogger print service");
    myLogger.log("service id = " + test_id);
  }
}
