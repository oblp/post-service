package xyz.eastack.article.domain.article;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final RabbitTemplate rabbitTemplate;

    public Article createArticle(Article article) {
        article.setStatus(ArticleStatus.CREATED);
        articleRepository.save(article);
        rabbitTemplate.convertAndSend("article-created", article);
        return article;
    }

    public void deleteArticle(ArticleId articleId) {
        articleRepository.deleteById(articleId);
    }
}
