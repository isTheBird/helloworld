package cn.how2j.trend.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cn.how2j.trend.pojo.IndexData;

/**
 * 使用 feign 模式从 INDEX-DATA-SERVICE 微服务获取数据。
 * 与之前使用的 RestTemplate 方式不同，这里是声明式的
 */
@FeignClient(value = "INDEX-DATA-SERVICE",fallback = IndexDataClientFeignHystrix.class)
public interface IndexDataClient {
    @GetMapping("/data/{code}")
    public List<IndexData> getIndexData(@PathVariable("code") String code);
}
