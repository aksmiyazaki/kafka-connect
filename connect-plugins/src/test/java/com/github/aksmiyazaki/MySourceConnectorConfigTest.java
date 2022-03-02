package com.github.aksmiyazaki;

import org.junit.Test;

public class MySourceConnectorConfigTest {
  @Test
  public void doc() {
    System.out.println(GithubSourceConnectorConfig.conf().toRst());
  }
}