package com.capensis.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wxg
 * @date 2022/3/6-14:10
 * @quotes 小不忍则乱大谋
 */
@Repository
public interface ProductDao extends ElasticsearchRepository<Product,Long> {
}
