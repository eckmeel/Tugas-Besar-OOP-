# Nangor Blast

Permainan Bomberman berbasis **CLI** dalam **Java** untuk Tugas Besar IF2010 Pemrograman Berorientasi Objek 2026.

Pemain mengendalikan **Deeper** untuk menyelidiki lorong bawah tanah di Nangor Falls. Deeper harus memasang bom untuk membuka jalan, mengalahkan seluruh Normal Enemy dan Boss Enemy, lalu mencapai pintu keluar sebelum waktu 300 detik habis.

| | |
|---|---|
| Kelompok | `<nomor kelompok>` |
| Tipe map | `<Green Garden / Blue Resort / Red Mountain / White Glacier / Black Fortress>` |
| Asisten | `<nama asisten>` |

## Anggota dan pembagian tugas

| Nama | NIM | Tugas |
|---|---|---|
| `<nama>` | `<NIM>` | F01 Player |
| `<nama>` | `<NIM>` | F02 Bomb |
| `<nama>` | `<NIM>` | F03 Explosion |
| `<nama>` | `<NIM>` | F04 Block |
| Akmal | `<NIM>` | F05 Enemy |
| `<belum dibagi>` | | F00 Inisialisasi, F06 Power-Up, F07 Map, F08 Score, F09 Game Flow |

## Status fitur

| Kode | Fitur | Package | Status |
|---|---|---|---|
| F00 | Inisialisasi Permainan | `nangorblast.core` | ⬜ Belum |
| F01 | Player | `nangorblast.player` | ⬜ Belum |
| F02 | Bomb | `nangorblast.bomb` | ⬜ Belum |
| F03 | Explosion | `nangorblast.explosion` | ⬜ Belum |
| F04 | Block | `nangorblast.block` | ⬜ Belum |
| F05 | Enemy | `nangorblast.enemy` | ⬜ Belum |
| F06 | Power-Up | `nangorblast.powerup` | ⬜ Belum |
| F07 | Map | `nangorblast.map` | ⬜ Belum |
| F08 | Score | `nangorblast.score` | ⬜ Belum |
| F09 | Game Flow | `nangorblast.flow` | ⬜ Belum |
| B01 | GUI | | ⬜ Belum |
| B02 | Bomb Kick | | ⬜ Belum |
| B03 | Map Maker | | ⬜ Belum |
| B04 | Local Multiplayer | | ⬜ Belum |
| B05 | Design Pattern | | ⬜ Belum |

Keterangan: ⬜ belum, 🟨 sedang dikerjakan, ✅ selesai

## Struktur repository

```
.
├── src/main/java/nangorblast/
│   ├── Main.java          entry point
│   ├── common/            kelas bersama: Position, Direction
│   ├── core/              F00 Inisialisasi Permainan
│   ├── player/            F01 Player
│   ├── bomb/              F02 Bomb
│   ├── explosion/         F03 Explosion
│   ├── block/             F04 Block
│   ├── enemy/             F05 Enemy
│   ├── powerup/           F06 Power-Up
│   ├── map/               F07 Map
│   ├── score/             F08 Score
│   └── flow/              F09 Game Flow (menu, game loop, input, render, pause)
├── config/maps/           layout map (.txt)
├── doc/                   dokumen PDF: class diagram, pembagian tugas, buklet, log activity
├── Makefile
├── pom.xml                (opsional, kalau pakai Maven)
└── README.md
```

Setiap anggota mengerjakan di folder package fiturnya masing-masing. Kelas yang dipakai banyak fitur, misalnya `Position` dan `Direction`, ditaruh di `common/` supaya tidak ada yang dobel.

## Kebutuhan

- JDK 21 atau lebih baru
- GNU Make (di Windows bisa lewat Git Bash)
- Maven (opsional)

## Cara compile dan menjalankan

```bash
make          # compile
make run      # compile lalu jalankan
make jar      # bikin build/NangorBlast.jar
make clean    # hapus hasil build
```

Dengan Maven:

```bash
mvn compile exec:java
```

## Kontrol (rencana)

| Tombol | Aksi |
|---|---|
| W / A / S / D | Bergerak atas / kiri / bawah / kanan |
| B | Pasang bomb |
| E | Pilih Pumped Bomb |
| N | Pilih Normal Bomb |
| Q | Detonate Remote Bomb |
| P | Pause |

## Legenda map

| Simbol | Arti | Simbol | Arti |
|---|---|---|---|
| `#` | Indestructible Block | `W` | Water Tile |
| `D` | Destructible Block | `S` | Switch |
| `R` | Reinforced Block | `G` / `g` | Gate CLOSED / OPEN |
| `.` | Walkable | `H` | Lava Tile |
| `P` | Player | `I` | Ice Tile |
| `E` | Normal Enemy | `L` | Laser Trap |
| `B` | Boss | `*` | Explosion |
| `X` | Exit | `!` | Warning |
| `+` `f` `s` `r` `h` | Power-Up: Bomb Up, Fire Up, Speed Up, Remote Detonator, Heart | | |

## Konsep OOP yang wajib

| Konsep | Diterapkan di |
|---|---|
| Inheritance | |
| Abstract Class / Interface | |
| Polymorphism | |
| Generics | |
| Exceptions | |
| Collections | |
| Concurrency | |

Design pattern (minimal 2):

-

SOLID principles (minimal 3):

-

## Alur kerja Git

1. Jangan push langsung ke `main`. Buat branch per fitur:
   ```bash
   git checkout -b feat/F02-bomb
   ```
2. Commit kecil dengan pesan yang jelas, misalnya `feat(F02): tambah PumpedBomb`.
3. Sebelum push, pastikan `make` berhasil, lalu ambil perubahan terbaru dari `main`:
   ```bash
   git pull origin main
   ```
4. Push branch, buat Pull Request ke `main`, minta satu anggota lain review, lalu merge.

## Timeline

| Kegiatan | Deadline |
|---|---|
| Asistensi 1 | 16 November 2026, 20.10 WIB |
| Milestone 1: link repo, pembagian tugas (PDF), class diagram (PDF) | 17 November 2026, 20.10 WIB |
| Asistensi 2 | 3 Desember 2026, 20.10 WIB |
| Milestone 2: release berisi source code, buklet, log activity (repo publik) | 4 Desember 2026, 20.10 WIB |
