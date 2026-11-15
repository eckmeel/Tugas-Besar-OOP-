package nangorblast.common;

/**
 * Posisi pada grid map. x = kolom, y = baris, keduanya 0-based
 * (kolom 1 / baris 1 pada layout spesifikasi = x 0 / y 0).
 *
 * Dipakai bersama oleh semua fitur. Jangan bikin kelas Position lain.
 */
public record Position(int x, int y) {

    public Position translate(Direction d) {
        return translate(d, 1);
    }

    public Position translate(Direction d, int n) {
        return new Position(x + d.dx() * n, y + d.dy() * n);
    }

    public Position offset(int dx, int dy) {
        return new Position(x + dx, y + dy);
    }

    public int manhattan(Position o) {
        return Math.abs(x - o.x) + Math.abs(y - o.y);
    }

    public int chebyshev(Position o) {
        return Math.max(Math.abs(x - o.x), Math.abs(y - o.y));
    }

    public boolean sameRowOrColumn(Position o) {
        return x == o.x || y == o.y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
