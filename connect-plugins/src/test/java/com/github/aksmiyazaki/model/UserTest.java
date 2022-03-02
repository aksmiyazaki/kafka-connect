package com.github.aksmiyazaki.model;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    String userStr = "{\n" +
            "\"login\": \"potatouser\",\n" +
            "\"id\": 20851561,\n" +
            "\"avatar_url\": \"https://avatars3.githubusercontent.com/u/20851561?v=3\",\n" +
            "\"gravatar_id\": \"\",\n" +
            "\"url\": \"https://api.github.com/users/potatouser\",\n" +
            "\"html_url\": \"https://github.com/potatouser\",\n" +
            "\"followers_url\": \"https://api.github.com/users/potatouser/followers\",\n" +
            "\"following_url\": \"https://api.github.com/users/potatouser/following{/other_user}\",\n" +
            "\"gists_url\": \"https://api.github.com/users/potatouser/gists{/gist_id}\",\n" +
            "\"starred_url\": \"https://api.github.com/users/potatouser/starred{/owner}{/repo}\",\n" +
            "\"subscriptions_url\": \"https://api.github.com/users/potatouser/subscriptions\",\n" +
            "\"organizations_url\": \"https://api.github.com/users/potatouser/orgs\",\n" +
            "\"repos_url\": \"https://api.github.com/users/potatouser/repos\",\n" +
            "\"events_url\": \"https://api.github.com/users/potatouser/events{/privacy}\",\n" +
            "\"received_events_url\": \"https://api.github.com/users/potatouser/received_events\",\n" +
            "\"type\": \"User\",\n" +
            "\"site_admin\": false\n" +
            "}";

    private JSONObject userJson = new JSONObject(userStr);

    @Test
    public void whenJSONIsComplete_thenItReadsSuccessfully() {
        User user = User.fromJson(userJson);
        assertEquals((Integer)20851561, user.getId());
        assertEquals("https://api.github.com/users/potatouser", user.getUrl());
        assertEquals("https://github.com/potatouser", user.getHtmlUrl());
        assertEquals("potatouser", user.getLogin());
    }
}
