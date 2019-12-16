package com.springbootlq03.demo.config;


import com.springbootlq03.demo.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{


     @Bean
    public WebMvcConfigurerAdapter WebMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/register.html").setViewName("register");
                registry.addViewController("/allmeeting.html").setViewName("allmeeting");
                registry.addViewController("/abc.html").setViewName("abc");
                registry.addViewController("/myattendmeeeting.html").setViewName("myattendmeeting");
                registry.addViewController("/a.html").setViewName("a");

                registry.addViewController("/b.html").setViewName("b");
                registry.addViewController("/meeting.html").setViewName("meeting");
                registry.addViewController("/user.html").setViewName("user");
                registry.addViewController("/postmeeting.html").setViewName("postmeeting");
                registry.addViewController("/add.html").setViewName("add");


            }


//            @Override拦截器
//            public void addInterceptors(InterceptorRegistry registry) {
////                super.addInterceptors(registry);
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/","/login.html","/user/login","/register.html","/user/register");
//
//            }
        };
        return adapter;
    }
    @Override
    public void addResourceHandlers(
            ResourceHandlerRegistry registry
    ) {
        registry.addResourceHandler("/static/**").
                addResourceLocations("classpath:/static/");
    }

    //将配置放到容器中，让它生效;国际化
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

//    @Bean
//    public ErrorPageFilter errorPageFilter() {
//        return new ErrorPageFilter();
//    }
//
//    @Bean
//    public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(filter);
//        filterRegistrationBean.setEnabled(false);
//        return filterRegistrationBean;
//    }

}
