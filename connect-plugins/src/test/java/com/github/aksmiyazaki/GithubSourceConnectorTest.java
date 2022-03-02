package com.github.aksmiyazaki;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.github.aksmiyazaki.GithubSourceConnectorConfig.*;
import static org.junit.Assert.assertEquals;

public class GithubSourceConnectorTest {

  private Map<String, String> initialConfig() {
    Map<String, String> props = new HashMap<>();
    props.put(OWNER_CONFIG, "potato");
    props.put(REPO_CONFIG, "tomato");
    props.put(SINCE_CONFIG, "2021-02-20T08:00:00Z");
    props.put(BATCH_SIZE_CONFIG, "100");
    props.put(TOPIC_CONFIG, "gitub-issues");
    return props;
  }

  @Test
  public void whenPassingAnyNumberOfTasksToConfigs_thenItAlwaysReturnListWithOneElement() {
    GithubSourceConnector conn = new GithubSourceConnector();
    conn.start(initialConfig());
    assertEquals(conn.taskConfigs(1).size(), 1);
    assertEquals(conn.taskConfigs(10).size(), 1);
  }
}
