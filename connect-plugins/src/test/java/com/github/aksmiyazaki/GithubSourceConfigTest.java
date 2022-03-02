package com.github.aksmiyazaki;

import org.junit.Test;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static com.github.aksmiyazaki.GithubSourceConnectorConfig.*;

public class GithubSourceConfigTest {

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
    public void doc() {
        System.out.println(GithubSourceConnectorConfig.conf().toRst());
    }

    @Test
    public void whenConfigIsComplete_thenItReadsSuccessfully() {
        Map<String, String> initConf = initialConfig();
        GithubSourceConnectorConfig cfg = new GithubSourceConnectorConfig(initConf);
        assert cfg.getOwnerConfig() == initConf.get(OWNER_CONFIG);
        assert cfg.getRepoConfig() == initConf.get(REPO_CONFIG);
        assert cfg.getBatchSizeConfig() == Integer.parseInt(initConf.get(BATCH_SIZE_CONFIG));
        assert cfg.getTopicConfig() == initConf.get(TOPIC_CONFIG);
        assert cfg.getSinceConfig().equals(Instant.parse(initConf.get(SINCE_CONFIG)));
    }
}
