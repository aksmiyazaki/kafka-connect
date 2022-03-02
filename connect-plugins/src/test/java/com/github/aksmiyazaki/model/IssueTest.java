package com.github.aksmiyazaki.model;

import org.json.JSONObject;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertEquals;

public class IssueTest {
    String issueStr = "{\n" +
            "  \"url\": \"https://api.github.com/repos/apache/kafka/issues/2800\",\n" +
            "  \"repository_url\": \"https://api.github.com/repos/apache/kafka\",\n" +
            "  \"labels_url\": \"https://api.github.com/repos/apache/kafka/issues/2800/labels{/name}\",\n" +
            "  \"comments_url\": \"https://api.github.com/repos/apache/kafka/issues/2800/comments\",\n" +
            "  \"events_url\": \"https://api.github.com/repos/apache/kafka/issues/2800/events\",\n" +
            "  \"html_url\": \"https://github.com/apache/kafka/pull/2800\",\n" +
            "  \"id\": 219155037,\n" +
            "  \"number\": 2800,\n" +
            "  \"title\": \"added interface to allow producers to create a ProducerRecord without…\",\n" +
            "  \"user\": {\n" +
            "    \"login\": \"potatouser\",\n" +
            "    \"id\": 20851561,\n" +
            "    \"avatar_url\": \"https://avatars3.githubusercontent.com/u/20851561?v=3\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https://api.github.com/users/potatouser\",\n" +
            "    \"html_url\": \"https://github.com/potatouser\",\n" +
            "    \"followers_url\": \"https://api.github.com/users/potatouser/followers\",\n" +
            "    \"following_url\": \"https://api.github.com/users/potatouser/following{/other_user}\",\n" +
            "    \"gists_url\": \"https://api.github.com/users/potatouser/gists{/gist_id}\",\n" +
            "    \"starred_url\": \"https://api.github.com/users/potatouser/starred{/owner}{/repo}\",\n" +
            "    \"subscriptions_url\": \"https://api.github.com/users/potatouser/subscriptions\",\n" +
            "    \"organizations_url\": \"https://api.github.com/users/potatouser/orgs\",\n" +
            "    \"repos_url\": \"https://api.github.com/users/potatouser/repos\",\n" +
            "    \"events_url\": \"https://api.github.com/users/potatouser/events{/privacy}\",\n" +
            "    \"received_events_url\": \"https://api.github.com/users/potatouser/received_events\",\n" +
            "    \"type\": \"User\",\n" +
            "    \"site_admin\": false\n" +
            "  },\n" +
            "  \"labels\": [],\n" +
            "  \"state\": \"closed\",\n" +
            "  \"locked\": false,\n" +
            "  \"assignee\": null,\n" +
            "  \"assignees\": [],\n" +
            "  \"milestone\": null,\n" +
            "  \"comments\": 12,\n" +
            "  \"created_at\": \"2017-04-04T06:47:09Z\",\n" +
            "  \"updated_at\": \"2017-04-19T22:36:21Z\",\n" +
            "  \"closed_at\": \"2017-04-19T22:36:21Z\",\n" +
            "  \"pull_request\": {\n" +
            "    \"url\": \"https://api.github.com/repos/apache/kafka/pulls/2800\",\n" +
            "    \"html_url\": \"https://github.com/apache/kafka/pull/2800\",\n" +
            "    \"diff_url\": \"https://github.com/apache/kafka/pull/2800.diff\",\n" +
            "    \"patch_url\": \"https://github.com/apache/kafka/pull/2800.patch\"\n" +
            "  },\n" +
            "  \"body\": \"… specifying a partition, making it more obvious that the parameter partition can be null\"\n" +
            "}";

    private JSONObject issueJson = new JSONObject(issueStr);
    
    @Test
    public void whenJSONIsComplete_thenItReadsSuccessfully() {
        Issue issue = Issue.fromJson(issueJson);
        
        assertEquals("https://api.github.com/repos/apache/kafka/issues/2800", issue.getUrl());
        assertEquals("https://github.com/apache/kafka/pull/2800", issue.getHtmlUrl());
        assertEquals(Instant.parse("2017-04-04T06:47:09Z"), issue.getCreatedAt());
        assertEquals("potatouser", issue.getUser().getLogin());
        assertEquals("https://github.com/apache/kafka/pull/2800", issue.getPullRequest().getHtmlUrl());

    }
}
