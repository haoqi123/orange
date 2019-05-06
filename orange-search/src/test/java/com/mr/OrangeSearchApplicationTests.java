package com.mr;

import com.mr.commont.commodity.Commodity;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrangeSearchApplicationTests {

    @Autowired
    private SolrClient solrClient;


    @Test
    public void contextLoads() throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery();
        String name = "小米";
        query.setQuery("c_name:" + name);
        QueryResponse response = solrClient.query(query);
        List<Commodity> list = response.getBeans(Commodity.class);

        for (Commodity c : list) System.out.println(c);
    }


}
