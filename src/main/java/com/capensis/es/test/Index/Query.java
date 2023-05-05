package com.capensis.es.test.Index;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * @author wxg
 * @date 2022/3/5-10:47
 * @quotes 小不忍则乱大谋
 */
@SuppressWarnings("DuplicatedCode")
public class Query {
    public static void main(String[] args) {
        // TODO 0、创建客户端对象
        final HttpHost httpHost = new HttpHost("localhost", 9200, "http");
        final RestClientBuilder restClientBuilder = RestClient.builder(httpHost);
        RestHighLevelClient client = new RestHighLevelClient(restClientBuilder);

        // TODO 1、查询索引 - 请求对象
        GetIndexRequest request = new GetIndexRequest("user");
        // 发送请求，获取响应
        GetIndexResponse response2 = null;
        try {
            response2 = client.indices().get(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response2 != null) {
            System.out.println("aliases: " + response2.getAliases());
            System.out.println("mappings: " + response2.getMappings());
            System.out.println("settings: " + response2.getSettings());
        }

        // TODO end 关闭客户端连接
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
