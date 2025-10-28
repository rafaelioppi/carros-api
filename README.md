# 🛠️ Back-End: API de Carros com Spring Boot

Este projeto é uma API REST desenvolvida com Spring Boot para gerenciar o cadastro e listagem de carros. Ele fornece endpoints para operações CRUD e está integrado ao front-end via HTTP.

## 📦 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Maven
- JPA + H2 (ou outro banco)
- GitHub Codespaces

## 🌐 URL da API

https://special-journey-v6vrv5wv46qghwp9j-3335.app.github.dev/carros

Código

## 🚀 Como executar

1. Compile e execute com Maven:
   ```bash
   mvn clean install
   mvn spring-boot:run
Certifique-se de que a porta 3335 está pública no Codespaces.

A API estará disponível em /carros.

🔗 Integração CORS
Adicione esta configuração global para permitir comunicação com o front-end:

@Configuration 

public class CorsConfig {

    @Bean
    
    public WebMvcConfigurer corsConfigurer() {
    
        return new WebMvcConfigurer() {
        
            @Override
            
            public void addCorsMappings(CorsRegistry registry) {
            
                registry.addMapping("/**")
                
                        .allowedOrigins("https://savage-goblin-x5wpw4xw6vpq366g6-5500.app.github.dev")
                        
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        
                        .allowedHeaders("*")
                        
                        .allowCredentials(false);
                        
            }
            
        };
        
    }
    
}

📋 Endpoints disponíveis
GET /carros — Listar todos os carros

GET /carros/{id} — Buscar carro por ID

POST /carros — Cadastrar novo carro

PUT /carros/{id} — Atualizar carro existente

DELETE /carros/{id} — Remover carro

📁 Estrutura de pacotes
Código

├── controller/

│   └── CarroController.java

├── model/

│   └── Carro.java

├── service/

│   └── CarroService.java

├── config/

│   └── CorsConfig.java




