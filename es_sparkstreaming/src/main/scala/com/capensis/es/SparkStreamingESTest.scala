package com.capensis.es

import java.util.Date

import org.apache.http.HttpHost
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.elasticsearch.action.index.{IndexRequest, IndexResponse}
import org.elasticsearch.client.{RequestOptions, RestClient, RestHighLevelClient}
import org.elasticsearch.common.xcontent.XContentType

/**
 * @author wxg
 * @date 2022/3/6-16:39
 * @quotes 小不忍则乱大谋
 */
object SparkStreamingESTest {
	def main(args: Array[String]): Unit = {
		val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("ESTest")
		val ssc = new StreamingContext(sparkConf, Seconds(3))
		val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)
		ds.foreachRDD(
			(rdd: RDD[String]) => {
				println("*************** " + new Date())
				rdd.foreach(
					(data: String) => {
						val client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")))
						// 新增文档 - 请求对象
						val request = new IndexRequest()
						// 设置索引及唯一性标识
						val ss: Array[String] = data.split(" ")
						println("ss = " + ss.mkString(","))
						request.index("sparkstreaming").id(ss(0))
						val productJson: String =("\n { \"data\":\"" + ss(1) + "\" }\n").stripMargin
						// 添加文档数据，数据格式为 JSON 格式
						request.source(productJson, XContentType.JSON)
						// 客户端发送请求，获取响应对象
						val response: IndexResponse = client.index(request,RequestOptions.DEFAULT)
						System.out.println("_index:" + response.getIndex)
						System.out.println("_id:" + response.getId)
						System.out.println("_result:" + response.getResult)
						client.close()
					}
				)
			}
		)
		ssc.start()
		ssc.awaitTermination()
	}
}
