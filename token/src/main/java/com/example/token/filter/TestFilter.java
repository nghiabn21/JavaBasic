package com.example.token.filter;
//
//import java.io.IOException;
//import java.util.Map;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Component;
//import org.springframework.util.StreamUtils;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Component
//public class TestFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
////Wrap the request
//        RequestWrapper wrapper = new RequestWrapper((HttpServletRequest) request);
////Get the input stream from the wrapper and convert it into byte array
//        byte[] body = StreamUtils.copyToByteArray(wrapper.getInputStream());
//// use jackson ObjectMapper to convert the byte array to Map (represents JSON)
//        Map<String, Object> jsonRequest = new ObjectMapper().readValue(body, Map.class);
//        System.out.println(jsonRequest);
//        chain.doFilter(wrapper, response);
//        return;
//    }
//}
