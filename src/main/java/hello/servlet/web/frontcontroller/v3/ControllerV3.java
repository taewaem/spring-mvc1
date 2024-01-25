package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    //v2에는 서블릿 기술이 들어갔지만 v3에는 서블릿 기술이 들어가있지 않고 우리가 직접 만들어서 사용한다.
    ModelView process(Map<String, String> paramMap);

}
