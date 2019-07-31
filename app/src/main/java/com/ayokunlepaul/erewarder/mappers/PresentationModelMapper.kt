package com.ayokunlepaul.erewarder.mappers

interface PresentationModelMapper <DOMAIN, PRESENTATION> {

    fun mapToDomain(presentation: PRESENTATION): DOMAIN

    fun mapToPresentation(domain: DOMAIN): PRESENTATION
}