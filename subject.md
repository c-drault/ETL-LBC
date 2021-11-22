# Prerequisite
- git
- Python or Java/Scala
- A Docker daemon running
- docker-compose

## Énoncé 
Create a solution that crawls for articles from a news website, cleanses the response, stores in a mongo database then makes it available to search via an API.

## What we need from you?
Create the repo, build your ETL process and commit the code with your answers.
Send us the link when you are ready.

## Expectations
- Include a step-by-step instruction to run your code.
- Use best practices: elaborate your code in a comprehensive and readable manner
- You are expected to be able to explain this whole process in a face-to-face interview. During the interview, you’ll have also to be able to justify the technical choices, your implementation and the advantages and limitations of your solution.
- Allow for 4-6 hours for this test.
- You are building a backend application and no UI is required, input can be provided using a configuration file or command line

## How you will be judged
You will be scored on,
- coding standard, comments and style
- unit testing strategy
- overall solution design
- appropriate use of source control

## Instructions
- Create a MongoDB instance in 0-docker-compose.yml
- Write an application to crawl an online news website, e.g. www.theguardian.com/ or BBC - Homepage using a crawler framework such as [Scrapy](Scrapy | A Fast and Powerful Scraping and Web Crawling Framework ). You can use a crawl framework of your choice and build the application in Python, Java or Scala.
- The appliction should cleanse the articles to obtain only information relevant to the news story, e.g. article text, author, headline, article url. Use a framework such as Readability to cleanse the page of superfluous content such as advertising and html
- Store the data in the mongo database, for subsequent search and retrieval.
- Write an API that provides access to the content in the mongo database. The user should be able to search for articles by keyword
- In a README file, explain:
    - how you can setup this kind of pipeline in production (e.g. not using Docker, a single Kafka broker…)
    - what are the limitation of this solution
    - how you can improve it, using an other technology or an other pattern
    - what is the advantages of using a schema registry