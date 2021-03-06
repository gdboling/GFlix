package com.gflix

import grails.test.*

class MovieTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
		mockDomain(Movie)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testNullables() {
		def movieInstance = new Movie()
		assertFalse 'validation should fail because not-nullable properties are null', movieInstance.validate()
		assertEquals 'title is required', 'nullable', movieInstance.errors.title
		assertEquals 'releaseDate is required', 'nullable', movieInstance.errors.releaseDate
    }

	void testSaveSuccessful() {
		def movieInstance = new Movie(title:"The Karate Kid", description: "Danial kicks Johnny's ass", releaseDate:new Date())
		movieInstance.save(flush:true)
		assertNotNull 'movie instance has no ID', movieInstance.id
	}
}
