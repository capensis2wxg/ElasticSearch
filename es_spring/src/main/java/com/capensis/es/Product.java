package com.capensis.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author wxg
 * @date 2022/3/6-14:11
 * @quotes 小不忍则乱大谋
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(indexName = "product", shards = 3, replicas = 1)
public class Product {
    /**
     *   必须有 id,这里的 id 是全局唯一的标识，等同于 es 中的"_id", 商品唯一标识
     */
    @Id
    private Long id;
    /*
      type : 字段数据类型
      analyzer : 分词器类型
      index : 是否索引(默认:true)
      Keyword : 短语,不进行分词
     */
    /**
     *    商品名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    /**
     * 分类名称
     */
    @Field(type = FieldType.Keyword)
    private String category;
    /**
     * 商品价格
     */
    @Field(type = FieldType.Double)
    private Double price;
    /**
     * 图片名称
     */
    @Field(type = FieldType.Keyword, index = false)
    private String images;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
