package com.ayokunlepaul.repository.mappers

interface RepositoryModelMapper <REPOSITORY, DOMAIN> {

    fun mapToRepository(domain: DOMAIN): REPOSITORY

    fun mapToDomain(repository: REPOSITORY): DOMAIN
}