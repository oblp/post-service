package me.eastack.post.sdk

data class AboutRepresentation(
    val appName: String,
    val buildNumber: String,
    val buildTime: String,
    val deployTime: String,
    val gitRevision: String,
    val gitBranch: String,
    val environment: String,
)