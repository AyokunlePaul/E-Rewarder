package com.ayokunlepaul.cache.mappers

interface CacheModelMapper <CACHE, REPOSITORY> {

    fun mapToCache(repository: REPOSITORY): CACHE

    fun mapToRepository(cache: CACHE): REPOSITORY

    fun mapToCacheList(repositories: List<REPOSITORY>): List<CACHE> {
        return repositories.map { mapToCache(it) }
    }

    fun mapToRepositoryList(caches: List<CACHE>): List<REPOSITORY> {
        return caches.map { mapToRepository(it) }
    }

    fun safeString(value: String?) = value?.let { it } ?: "N/A"

    fun safeCacheList(caches: List<CACHE>?) = caches?.let { it } ?: emptyList()

    fun safeRepositoryList(repositories: List<REPOSITORY>?) = repositories?.let { it } ?: emptyList()
}