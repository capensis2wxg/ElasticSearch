package com.capensis.es.test.Index;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author wxg
 * @date 2022/3/5-10:49
 * @quotes 小不忍则乱大谋
 */
public class Delete {
    public static void main(String[] args) {
        // TODO 0、创建客户端对象
        final HttpHost httpHost = new HttpHost("localhost", 9200, "http");
        final RestClientBuilder restClientBuilder = RestClient.builder(httpHost);
        RestHighLevelClient client = new RestHighLevelClient(restClientBuilder);

        // TODO 1、删除索引 - 请求对象
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("user");
        // 发送请求，获取响应
        AcknowledgedResponse response = null;
        try {
            response = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 操作结果
        if (response != null) {
            System.out.println("操作结果 ： " + response.isAcknowledged());
        }


        // TODO end 关闭客户端连接
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
