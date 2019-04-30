package com.mr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrangeSearchApplicationTests {

	@Autowired
	private SolrClient solrClient;


	@Test
	public void contextLoads() throws IOException, SolrServerException {
		/*solrClient.deleteByQuery("*:*");
		solrClient.commit();*/
	}

}
