package com.capensis.es.test.doc;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

/**
 * @author capensis
 */
@SuppressWarnings("AlibabaRemoveCommentedCode")
public class Query {
    public static void main(String[] args) throws Exception {
        
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 1. 查询索引中全部的数据
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        // 创建查询条件
//        final MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
//        // 设置查询请求
//        final SearchSourceBuilder query = new SearchSourceBuilder().query(matchAllQueryBuilder);
//        // 传入查询请求
//        request.source(query);
//        // 执行查询请求
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//        // 查看响应结果
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());


        // 2. 条件查询 : termQuery
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age", 30)));
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());


        // 3. 分页查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        // (当前页码-1)*每页显示数据条数
//        builder.from(2);
//        builder.size(2);
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//


//        // 4. 查询排序
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        builder.sort("age", SortOrder.DESC);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());



//        // 5. 过滤字段
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        String[] excludes = {"age"};
//        String[] includes = {};
//        builder.fetchSource(includes, excludes);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());


//        // 6. 组合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//
//        //boolQueryBuilder.must(QueryBuilders.matchQuery("age", 30));
//        //boolQueryBuilder.must(QueryBuilders.matchQuery("sex", "男"));
//        //boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex", "男"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 30));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 40));
//
//        builder.query(boolQueryBuilder);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());



//        // 7. 范围查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//
//        rangeQuery.gte(30);
//        rangeQuery.lt(50);
//
//        builder.query(rangeQuery);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());


        // 8. 模糊查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        builder.query(QueryBuilders
//                .fuzzyQuery("name", "wangwu")
//                // Fuzziness.TWO 在多余两个以内的字符也可以被查到
//                .fuzziness(Fuzziness.TWO));
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());


//        // 9. 高亮查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("name", "zhangsan");
//
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("name");
//
//        builder.highlighter(highlightBuilder);
//        builder.query(termsQueryBuilder);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());


//        // 10. 聚合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        AggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//        builder.aggregation(aggregationBuilder);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());


        // 11. 分组查询
        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder();

        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");
        builder.aggregation(aggregationBuilder);

        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();

        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        System.out.println(response);
        for ( SearchHit hit : hits ) {
            System.out.println(hit.getSourceAsString());
        }


        //  关闭客户端
        esClient.close();
    }
}
