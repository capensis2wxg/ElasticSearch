package com.capensis.es.test.Index;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * @author wxg
 * @date 2022/3/4-22:34
 * @quotes 小不忍则乱大谋
 */
@SuppressWarnings("AlibabaRemoveCommentedCode")
public class Create {
    public static void main(String[] args) throws IOException {
        // TODO 0、创建客户端对象
        final HttpHost httpHost = new HttpHost("localhost", 9200, "http");
        final RestClientBuilder restClientBuilder = RestClient.builder(httpHost);
        RestHighLevelClient client = new RestHighLevelClient(restClientBuilder);

        // TODO 1、创建索引 - 请求对象
        // 发送请求，获取响应
        CreateIndexResponse response1 = null;
        try {
            response1 = client.indices().create(new CreateIndexRequest("user"), RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean acknowledged = false;
        if (response1 != null) {
            acknowledged = response1.isAcknowledged();
        }
        // 响应状态
        System.out.println("操作状态 = " + acknowledged);

        // TODO end 关闭客户端连接
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
