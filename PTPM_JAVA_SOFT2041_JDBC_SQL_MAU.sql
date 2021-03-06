USE [SOFT2041_PTPM]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 5/15/2022 9:34:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 5/15/2022 9:34:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NULL,
	[price] [numeric](19, 2) NULL,
	[category_id] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([id], [name]) VALUES (CAST(1 AS Numeric(19, 0)), N'Tiêu dùng')
INSERT [dbo].[Category] ([id], [name]) VALUES (CAST(2 AS Numeric(19, 0)), N'Thực phẩm')
INSERT [dbo].[Category] ([id], [name]) VALUES (CAST(3 AS Numeric(19, 0)), N'Khác')
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([id], [name], [price], [category_id]) VALUES (CAST(1 AS Numeric(19, 0)), N'Bàn chải', CAST(10000.00 AS Numeric(19, 2)), CAST(1 AS Numeric(19, 0)))
INSERT [dbo].[Product] ([id], [name], [price], [category_id]) VALUES (CAST(8 AS Numeric(19, 0)), N'Dungna', CAST(1.00 AS Numeric(19, 2)), CAST(1 AS Numeric(19, 0)))
INSERT [dbo].[Product] ([id], [name], [price], [category_id]) VALUES (CAST(9 AS Numeric(19, 0)), N'2', CAST(2.00 AS Numeric(19, 2)), CAST(2 AS Numeric(19, 0)))
INSERT [dbo].[Product] ([id], [name], [price], [category_id]) VALUES (CAST(10 AS Numeric(19, 0)), N'2', CAST(2.00 AS Numeric(19, 2)), CAST(1 AS Numeric(19, 0)))
INSERT [dbo].[Product] ([id], [name], [price], [category_id]) VALUES (CAST(11 AS Numeric(19, 0)), N'23', CAST(33.00 AS Numeric(19, 2)), CAST(2 AS Numeric(19, 0)))
SET IDENTITY_INSERT [dbo].[Product] OFF
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FKexqqeaksnmmku5py194ywp140] FOREIGN KEY([category_id])
REFERENCES [dbo].[Category] ([id])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FKexqqeaksnmmku5py194ywp140]
GO
