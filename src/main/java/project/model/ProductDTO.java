package project.model;

public record ProductDTO(String name,
                         String category,
                         Float price,
                         Integer stock,
                         User user) {
}
