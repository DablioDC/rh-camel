USE [DataTransaction]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


CREATE TABLE [camel].[rh_operation_log](
    [Id] [bigint] IDENTITY(1,1) NOT NULL,
    [db_time] [datetime] NOT NULL,
    [operation] [varchar](20) NOT NULL,
    [numemp] [smallint] NOT NULL,
    [numcad] [int] NULL,
    [nomfun] [varchar](80) NOT NULL,
    [numcpf] [bigint] NOT NULL,
    [login] [varchar](40) NULL,
    [incident] [varchar](18) NOT NULL,
    [operatorGroup] [varchar](255) NULL
    CONSTRAINT [PK_RhOperationLog] PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
