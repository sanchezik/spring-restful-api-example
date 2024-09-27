package com.tsatserski.restfulapiexample;

import com.tsatserski.restfulapiexample.model.BlogPostEntity;
import com.tsatserski.restfulapiexample.model.CommentEntity;
import com.tsatserski.restfulapiexample.repository.BlogPostRepository;
import com.tsatserski.restfulapiexample.repository.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initBlogPosts(BlogPostRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new BlogPostEntity("5 Quick Tips to Boost Productivity While Working from Home", "Working from home can be challenging, but with these five tips, you can stay productive. 1) Create a dedicated workspace free from distractions. 2) Set clear work hours and stick to them. 3) Take regular breaks to recharge your mind. 4) Use productivity tools like to-do lists. 5) Limit social media during work hours. Implementing these strategies can make remote work more efficient and enjoyable.")));
            log.info("Preloading " + repository.save(new BlogPostEntity("Why Morning Exercise Sets the Tone for a Successful Day", "Starting your day with exercise boosts energy, improves mood, and enhances focus. Just 20 minutes of physical activity releases endorphins, reduces stress, and prepares you mentally for daily tasks. Morning workouts also help regulate sleep patterns and create a sense of accomplishment. Make it a habit, and you’ll notice increased productivity and positivity throughout your day.")));
        };
    }

    @Bean
    CommandLineRunner initComments(CommentRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new CommentEntity(1L, "Thanks for the info")));
            log.info("Preloading " + repository.save(new CommentEntity(1L, "Very useful tips")));
            log.info("Preloading " + repository.save(new CommentEntity(2L, "It works!")));
            log.info("Preloading " + repository.save(new CommentEntity(2L, "Awful :(")));
            log.info("Preloading " + repository.save(new CommentEntity(2L, "hahahaha very entertaining")));
        };
    }
}