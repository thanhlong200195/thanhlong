-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 19, 2018 at 03:38 AM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ffse1703`
--

-- --------------------------------------------------------

--
-- Table structure for table `danhgiabanthan`
--

CREATE TABLE `danhgiabanthan` (
  `Id` int(11) NOT NULL,
  `KyDanhGia` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `PhongBan` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `NhanVien` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `KyLuatCongViec_DG` tinyint(1) NOT NULL,
  `KyLuatCongViec_MT` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `TinhThanLamViec_DG` tinyint(1) NOT NULL,
  `TinhThanLamViec_MT` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `KhoiLuongCongViec_DG` tinyint(1) NOT NULL,
  `KhoiLuongCongViec_MT` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `KetQuaCongViec_DG` tinyint(1) NOT NULL,
  `KetQuaCongViec_MT` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `KyNangTichLuy_DG` tinyint(1) NOT NULL,
  `KyNangTichLuy_MT` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `DinhHuong` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `DanhGiaTongThe` int(1) NOT NULL,
  `TrangThai` int(1) NOT NULL,
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `kydanhgia`
--

CREATE TABLE `kydanhgia` (
  `Id` int(11) NOT NULL,
  `MaKy` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `TenKy` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `MoTa` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `IsDelete` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nhanviendanhgia`
--

CREATE TABLE `nhanviendanhgia` (
  `Id` int(11) NOT NULL,
  `KyDanhGia` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `PhongBan` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `NhanVienDanhGia` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `NhanVien` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `TinhThanLamViec` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `KhoiLuongCongViec` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `KetQuaDatDuoc` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `KyNangTichLuy` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `DinhHuong` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `XepLoai` tinyint(1) NOT NULL,
  `TrangThai` tinyint(1) NOT NULL,
  `IsDelete` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `phancongdanhgia`
--

CREATE TABLE `phancongdanhgia` (
  `Id` int(11) NOT NULL,
  `KyDanhGia` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `PhongBan` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `NhanVienDanhGia` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `NhanVien` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `IsDelete` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `danhgiabanthan`
--
ALTER TABLE `danhgiabanthan`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `kydanhgia`
--
ALTER TABLE `kydanhgia`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `nhanviendanhgia`
--
ALTER TABLE `nhanviendanhgia`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `phancongdanhgia`
--
ALTER TABLE `phancongdanhgia`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danhgiabanthan`
--
ALTER TABLE `danhgiabanthan`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kydanhgia`
--
ALTER TABLE `kydanhgia`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nhanviendanhgia`
--
ALTER TABLE `nhanviendanhgia`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `phancongdanhgia`
--
ALTER TABLE `phancongdanhgia`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
