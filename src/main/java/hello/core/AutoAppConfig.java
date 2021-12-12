package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    // Bean 이 등록될때 어디서 부터 찾을지 위치를 명시할수 있음
    // 지정하지 않으면 기본값은 현재 Annotation 이 붙은 패키지 의 하위를 탐색
    /* basePackages = "hello.core.member", */
    excludeFilters =
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {}
