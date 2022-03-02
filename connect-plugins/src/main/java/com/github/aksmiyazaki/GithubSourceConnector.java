package com.github.aksmiyazaki;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GithubSourceConnector extends SourceConnector {
  private static Logger log = LoggerFactory.getLogger(GithubSourceConnector.class);
  private GithubSourceConnectorConfig config;

  @Override
  public String version() {
    return VersionUtil.getVersion();
  }

  @Override
  public void start(Map<String, String> map) {
    config = new GithubSourceConnectorConfig(map);
  }

  @Override
  public Class<? extends Task> taskClass() {
    return GithubSourceTask.class;
  }

  @Override
  public List<Map<String, String>> taskConfigs(int i) {
    ArrayList<Map<String, String>> configs = new ArrayList<>(1);
    configs.add(config.originalsStrings());
    return configs;
  }

  @Override
  public void stop() {
  }

  @Override
  public ConfigDef config() {
    return GithubSourceConnectorConfig.conf();
  }
}
