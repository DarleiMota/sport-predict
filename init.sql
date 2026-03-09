-- Script de inicialização do banco de dados
-- Este script será executado automaticamente quando o container PostgreSQL iniciar

-- Habilitar extensão UUID (útil para IDs)
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Configurar timezone
SET timezone = 'America/Sao_Paulo';

-- Mensagem de confirmação
SELECT 'Banco de dados SportPredict inicializado com sucesso!' AS message;
