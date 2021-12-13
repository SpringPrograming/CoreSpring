package hello.core.web;

import hello.core.common.MyLogger;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogDemoController {

  private final LogDemoService logDemoService;
  private final ObjectProvider<MyLogger> myLoggerObjectProvider;

  public LogDemoController(LogDemoService logDemoService,
      ObjectProvider<MyLogger> myLoggerObjectProvider) {
    this.logDemoService = logDemoService;
    this.myLoggerObjectProvider = myLoggerObjectProvider;
  }


  @RequestMapping("log-demo")
  @ResponseBody
  public String logDemo(HttpServletRequest request) {
    MyLogger myLogger = myLoggerObjectProvider.getObject();
    System.out.println(myLogger + "mylogger print controller");
    String requestURL = request.getRequestURL().toString();
    myLogger.setRequestURL(requestURL);

    myLogger.log("controller test");
    logDemoService.logic("test id");
    return "OK";
  }

}
