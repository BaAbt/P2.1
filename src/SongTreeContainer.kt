class SongTreeContainer {
    private var root : ANode<Song> = EmptyNode

    fun addSorted(s:Song){ root = root.add(s)}

    fun size() = root.size()

    fun spieldauer() = root.sumBy{it.spieldauer}

    fun forEachSong( f: (song:Song) -> Unit) { root.forEach(f)}

    fun sumBy(selector: (Song)-> Int ){ root.sumBy(selector)}

    fun clear() { root = EmptyNode }

    fun height() = root.height(0)

    fun size(cond: (song:Song) -> Boolean) = root.size(cond)

    override fun toString(): String {
        return root.painting()
    }

}