package com.github.aksmiyazaki.model;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.github.aksmiyazaki.GithubSchemas.PR_HTML_URL_FIELD;
import static com.github.aksmiyazaki.GithubSchemas.PR_URL_FIELD;

public class PullRequest {
    private String url;
    private String htmlUrl;
    private String diffUrl;
    private String patchUrl;
    private Map<String, Object> additionalProperties = new HashMap();

    public PullRequest() {
    }

    public static PullRequest fromJson(JSONObject pullRequest) {
        PullRequest pr = new PullRequest();
        pr.setUrl(pullRequest.getString(PR_URL_FIELD));
        pr.setHtmlUrl(pullRequest.getString(PR_HTML_URL_FIELD));
        return pr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getDiffUrl() {
        return diffUrl;
    }

    public void setDiffUrl(String diffUrl) {
        this.diffUrl = diffUrl;
    }

    public String getPatchUrl() {
        return patchUrl;
    }

    public void setPatchUrl(String patchUrl) {
        this.patchUrl = patchUrl;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
