INSERT INTO livros (id, titulo) VALUES
(1, 'Aventuras no Mar'),
(2, 'Viagens ao Espaço'),
(3, 'Mistérios da Floresta');

INSERT INTO capitulos (id, titulo, livro_id) VALUES
(1, 'Capítulo 1: A Partida', 1),
(2, 'Capítulo 2: A Tempestade', 1);

INSERT INTO capitulos (id, titulo, livro_id) VALUES
(3, 'Capítulo 1: A Decolagem', 2),
(4, 'Capítulo 2: A Órbita', 2);

INSERT INTO capitulos (id, titulo, livro_id) VALUES
(5, 'Capítulo 1: O Caminho', 3),
(6, 'Capítulo 2: Os Sons da Noite', 3);

INSERT INTO paginas (id, numero, conteudo, capitulo_id) VALUES
(1, 1, 'Conteúdo da página 1 do Capítulo 1 do Livro 1.', 1),
(2, 2, 'Conteúdo da página 2 do Capítulo 1 do Livro 1.', 1),
(3, 3, 'Conteúdo da página 1 do Capítulo 2 do Livro 1.', 2),
(4, 4, 'Conteúdo da página 2 do Capítulo 2 do Livro 1.', 2);

INSERT INTO paginas (id, numero, conteudo, capitulo_id) VALUES
(5, 1, 'Conteúdo da página 1 do Capítulo 1 do Livro 2.', 3),
(6, 2, 'Conteúdo da página 2 do Capítulo 1 do Livro 2.', 3),
(7, 3, 'Conteúdo da página 1 do Capítulo 2 do Livro 2.', 4),
(8, 4, 'Conteúdo da página 2 do Capítulo 2 do Livro 2.', 4);

INSERT INTO paginas (id, numero, conteudo, capitulo_id) VALUES
(9, 1, 'Conteúdo da página 1 do Capítulo 1 do Livro 3.', 5),
(10, 2, 'Conteúdo da página 2 do Capítulo 1 do Livro 3.', 5),
(11, 3, 'Conteúdo da página 1 do Capítulo 2 do Livro 3.', 6),
(12, 4, 'Conteúdo da página 2 do Capítulo 2 do Livro 3.', 6);
