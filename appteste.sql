-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Nov 25, 2013 as 10:42 AM
-- Versão do Servidor: 5.5.8
-- Versão do PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `appteste`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cargo`
--

CREATE TABLE IF NOT EXISTS `cargo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `nivelAcesso` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `cargo`
--

INSERT INTO `cargo` (`id`, `nome`, `descricao`, `nivelAcesso`) VALUES
(1, 'Gerente', 'gerente', 'total'),
(2, 'teste', 'teste', ''),
(3, 'teste02', 'teste02', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE IF NOT EXISTS `cidade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `id_estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `estado_fk_idx` (`id_estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`id`, `nome`, `id_estado`) VALUES
(1, 'Criciúma', 24),
(2, 'São Paulo', 25);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rasaoSocial` varchar(45) DEFAULT NULL,
  `nomeFantasia` varchar(45) DEFAULT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `ie` varchar(45) DEFAULT NULL,
  `im` varchar(45) DEFAULT NULL,
  `dataContrato` date DEFAULT NULL,
  `id_endereco` int(11) DEFAULT NULL,
  `id_contato` int(11) DEFAULT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `sobrenome` varchar(200) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `rg` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `clientePJ_endereco_fk_idx` (`id_endereco`),
  KEY `clientePJ_contato_fk_idx` (`id_contato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `cliente`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `clientelogin`
--

CREATE TABLE IF NOT EXISTS `clientelogin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `ip` varchar(45) DEFAULT NULL,
  `mac` varchar(45) DEFAULT NULL,
  `tipoAcesso` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `clientelogin`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `contato`
--

CREATE TABLE IF NOT EXISTS `contato` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `site` varchar(45) DEFAULT NULL,
  `telefone1` varchar(45) DEFAULT NULL,
  `telefone2` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=71 ;

--
-- Extraindo dados da tabela `contato`
--

INSERT INTO `contato` (`id`, `email`, `site`, `telefone1`, `telefone2`, `celular`) VALUES
(2, 'sc', NULL, '79798789', NULL, '98789789'),
(3, 'sc', 'dfgd', '98789789', '456456', '987987'),
(4, 'hgjh', NULL, '8798789', NULL, '98789'),
(5, 'sc', NULL, '878978', NULL, '987897'),
(6, 'scc', NULL, '', NULL, ''),
(7, 'scc', NULL, '', NULL, ''),
(8, '', NULL, '', NULL, ''),
(9, 'scc', NULL, '', NULL, ''),
(10, 'scc', NULL, '', NULL, ''),
(11, 'scs', NULL, '', NULL, ''),
(12, 'scs', NULL, '', NULL, ''),
(13, 'scs', NULL, '', NULL, ''),
(14, 'sc', NULL, '', NULL, ''),
(15, 'scsss', NULL, '', NULL, ''),
(16, 'scss', NULL, '', NULL, ''),
(17, 'scss', NULL, '', NULL, ''),
(18, 'kjhjkh', 'kjhkjhkjhkjh', '89789789', '98789789', '987897'),
(19, 'jhkjhkj', 'kjkljkljkljkl', '87878', '98789789', '98789798'),
(20, '09890', '0989089', '89890', '0989089', '809890'),
(21, '897897', NULL, '7897897', NULL, '8978'),
(22, '897897', NULL, '897897', NULL, '987897'),
(23, 'lkjklj', NULL, '788978', NULL, '98787897'),
(24, 'jhkjh', '', '878978', '', '7897879'),
(25, '89089', 'xxx', '909089', 'xxx', '9099'),
(26, '9879', 'xxx', '787897', 'xxx', '89789'),
(27, 'jkhjkh', 'xxx', '89789789', 'xxx', '7897897'),
(28, 'sc', 'xxx', '876876876', 'xxx', '876876786'),
(29, 'sc', 'xxx', '876876876', 'xxx', '876876786'),
(30, 'kjhkjhjk', 'xxx', '7987897', 'xxx', '98789789'),
(31, '89787', 'xxx', '987897', 'xxx', '987897'),
(32, '89787', 'xxx', '987897', 'xxx', '987897'),
(33, '8787', 'xxx', '789787', 'xxx', '987897'),
(34, 'kjhjkh', 'xxx', '678686', 'xxx', '876786'),
(35, 'hgjhghj', 'ghgjhgh', '567565', '908908', '354345'),
(36, 'sc', NULL, '76786786', '876786786', '87678678'),
(37, 'jhjk12', NULL, '8912', '90890812', '09890812'),
(38, '', NULL, '', '', ''),
(39, 'hgjhg', NULL, '78676', '786786786', '7867868'),
(40, 'hjgh2', NULL, '8978972', '8978978972', '8978972'),
(41, 'jkhj', NULL, '789798', '90890890', '09890890'),
(42, 'sc', NULL, '878989', '897897897', '987897897'),
(43, 'jkhjkhj', NULL, '8787878787', NULL, '8787878787'),
(44, 'jkhjkhj', NULL, '8787878787', NULL, '8787878787'),
(45, 'ljhkljkl', NULL, '7897897897', NULL, '8978789789'),
(46, 'jkhjkhjk', NULL, '7867867867', NULL, '8787878787'),
(47, 'jkhjkhjk', NULL, '7867867867', NULL, '8787878787'),
(48, 'jkhjkhjk', NULL, '7867867867', NULL, '8787878787'),
(49, 'jkhjkhjk', NULL, '7867867867', NULL, '8787878787'),
(50, 'jkhjkhjk', NULL, '7867867867', NULL, '8787878787'),
(51, 'hjjk', NULL, '0989089089', NULL, '9889089089'),
(52, 'hjjk', NULL, '0989089089', NULL, '9889089089'),
(53, 'hjjk', NULL, '0989089089', NULL, '9889089089'),
(54, 'hjjk', NULL, '0989089089', NULL, '9889089089'),
(55, 'hjjk', NULL, '0989089089', NULL, '9889089089'),
(56, 'khjkhjkh', NULL, '8978978978', NULL, '8978978978'),
(57, 'khjkhjkh', NULL, '8978978978', NULL, '8978978978'),
(58, 'ljlkjklj', NULL, '8978978978', NULL, '9789789789'),
(59, 'jkhjkhjkh', NULL, '8978978978', NULL, '8978978978'),
(60, 'kjhjhjkh', NULL, '7898789789', NULL, '8789789787'),
(61, 'hjklhjkh', NULL, '8789789789', NULL, '8978978978'),
(62, 'jkhjkhjkh', NULL, '8978978978', NULL, '8978989789'),
(63, 'kjhjkhjkh', NULL, '9878978978', NULL, '7897897897'),
(64, 'jhjkhjkh', NULL, '8978978978', NULL, '8978978978'),
(65, 'jhghjghjg', 'jhghjgjhghjg', '9867897897', '9878979879', '7987987987'),
(66, 'jkhjkhjhjk', NULL, '7867867867', '8767867867', '8767867867'),
(67, 'jkgjhghjghj', NULL, '8768767867', NULL, '7678678678'),
(68, 'jhjhjkhkjhjk', NULL, '8768767867', NULL, '7678678678'),
(69, 'jkhkjhjkhjkh', NULL, '7896678678', NULL, '9878978978'),
(70, 'jkhhkjk', NULL, '8978978978', NULL, '7898789789');

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rasaoSocial` varchar(45) DEFAULT NULL,
  `nomeFantasia` varchar(45) DEFAULT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `ie` varchar(45) DEFAULT NULL,
  `im` varchar(45) DEFAULT NULL,
  `codAnatel` varchar(45) DEFAULT NULL,
  `id_endereco` int(11) DEFAULT NULL,
  `id_contato` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `empresa_end_fk` (`id_endereco`),
  KEY `empresa_cont_fk` (`id_contato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `empresa`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE IF NOT EXISTS `endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(45) DEFAULT NULL,
  `rua` varchar(45) DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `id_cidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cidade_fk` (`id_cidade`),
  KEY `cidade_fk_idx` (`id_cidade`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=67 ;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id`, `bairro`, `rua`, `numero`, `complemento`, `cep`, `id_cidade`) VALUES
(1, 'Pinheirinho', 'Imigrante Thome', '200', 'casa', '88805050', 1),
(66, 'teste', 'ghhjgjhgjhg', '7867', 'ghjhgjhghj', '76786786', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `estados`
--

CREATE TABLE IF NOT EXISTS `estados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sigla` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=28 ;

--
-- Extraindo dados da tabela `estados`
--

INSERT INTO `estados` (`id`, `sigla`, `nome`) VALUES
(1, 'AC', 'Acre'),
(2, 'AL', 'Alagoas'),
(3, 'AP', 'Amapá'),
(4, 'AM', 'Amazonas'),
(5, 'BA', 'Bahia'),
(6, 'CE', 'Ceará'),
(7, 'DF', 'Distrito Federal'),
(8, 'ES', 'Espírito Santo'),
(9, 'GO', 'Goiás'),
(10, 'MA', 'Maranhão'),
(11, 'MT', 'Mato Grosso'),
(12, 'MS', 'Mato Grosso do Sul'),
(13, 'MG', 'Minas Gerais'),
(14, 'PA', 'Pará'),
(15, 'PB', 'Paraíba'),
(16, 'PR', 'Paraná'),
(17, 'PE', 'Pernambuco'),
(18, 'PI', 'Piauí'),
(19, 'RJ', 'Rio de Janeiro'),
(20, 'RN', 'Rio Grande do Norte'),
(21, 'RS', 'Rio Grande do Sul'),
(22, 'RO', 'Rondônia'),
(23, 'RR', 'Roraima'),
(24, 'SC', 'Santa Catarina'),
(25, 'SP', 'São Paulo'),
(26, 'SE', 'Sergipe'),
(27, 'TO', 'Tocantins');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE IF NOT EXISTS `fornecedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rasaoSocial` varchar(45) DEFAULT NULL,
  `nomeFantasia` varchar(45) DEFAULT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `ie` varchar(45) DEFAULT NULL,
  `nomeContato` varchar(45) DEFAULT NULL,
  `im` varchar(45) DEFAULT NULL,
  `id_endereco` int(11) DEFAULT NULL,
  `id_contato` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fornecedor_endereco_fk` (`id_endereco`),
  KEY `fornecedor_contato_fk` (`id_contato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `fornecedor`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `sobrenome` varchar(100) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `rg` varchar(20) DEFAULT NULL,
  `sexo` varchar(9) DEFAULT NULL,
  `ctps` int(11) DEFAULT NULL,
  `admissao` date DEFAULT NULL,
  `login` varchar(30) DEFAULT NULL,
  `senha` varchar(20) DEFAULT NULL,
  `id_endereco` int(11) DEFAULT NULL,
  `id_contato` int(11) DEFAULT NULL,
  `id_cargo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `endereco_fk` (`id_endereco`),
  KEY `contato_fk` (`id_contato`),
  KEY `cargo_fk_idx` (`id_cargo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `nome`, `sobrenome`, `cpf`, `rg`, `sexo`, `ctps`, `admissao`, `login`, `senha`, `id_endereco`, `id_contato`, `id_cargo`) VALUES
(10, 'Ricardo', 'Garcia', '06972930928', '87897897', 'Masculino', 876876867, '2013-11-20', 'admin', 'admin', 66, 67, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `plano`
--

CREATE TABLE IF NOT EXISTS `plano` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `velocidade` varchar(45) DEFAULT NULL,
  `download` varchar(45) DEFAULT NULL,
  `upload` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `plano`
--

INSERT INTO `plano` (`id`, `nome`, `descricao`, `velocidade`, `download`, `upload`) VALUES
(1, 'Plano 1 mega', '1 mega', '1024k', '100k', '50k');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `quantEstoque` int(11) DEFAULT NULL,
  `quantMinima` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `produto`
--


--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `cidade`
--
ALTER TABLE `cidade`
  ADD CONSTRAINT `estado_fk` FOREIGN KEY (`id_estado`) REFERENCES `estados` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `clientePJ_contato_fk` FOREIGN KEY (`id_contato`) REFERENCES `contato` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `clientePJ_endereco_fk` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `empresa`
--
ALTER TABLE `empresa`
  ADD CONSTRAINT `empresa_cont_fk` FOREIGN KEY (`id_contato`) REFERENCES `contato` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `empresa_end_fk` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `endereco`
--
ALTER TABLE `endereco`
  ADD CONSTRAINT `cidade_fk` FOREIGN KEY (`id_cidade`) REFERENCES `cidade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `fornecedor_contato_fk` FOREIGN KEY (`id_contato`) REFERENCES `contato` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fornecedor_endereco_fk` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `cargo_fk` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `contato_fk` FOREIGN KEY (`id_contato`) REFERENCES `contato` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `endereco_fk` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
