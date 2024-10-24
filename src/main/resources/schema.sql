CREATE TABLE livros (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL
);

CREATE TABLE capitulos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    livro_id INTEGER NOT NULL,
    CONSTRAINT fk_capitulo_livro FOREIGN KEY (livro_id)
        REFERENCES livros (id) ON DELETE CASCADE
);

CREATE TABLE paginas (
    id SERIAL PRIMARY KEY,
    numero INTEGER NOT NULL,
    conteudo TEXT,
    capitulo_id INTEGER NOT NULL,
    CONSTRAINT fk_pagina_capitulo FOREIGN KEY (capitulo_id)
        REFERENCES capitulos (id) ON DELETE CASCADE
);
