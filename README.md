# 🧠 Teach: алгоритмы и структуры данных

Мои решения задач с LeetCode на **Java** и учебные реализации алгоритмов. Репозиторий для практики: разбираю темы по порядку и записываю идею каждого решения.

![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)
![LeetCode](https://img.shields.io/badge/LeetCode-46%20решено-FFA116?logo=leetcode&logoColor=white)

---

## 📊 Статистика

Решено задач: **46**, из них 🟢 Easy: **30**, 🟡 Medium: **16**.

| Тема | Задач |
| --- | --- |
| 🔎 Бинарный поиск | 3 |
| 👉 Два указателя | 8 |
| 🪟 Скользящее окно | 3 |
| 🗃 Хэш-таблицы | 9 |
| 📚 Стеки и очереди | 5 |
| 🔗 Связные списки | 5 |
| 🌳 Деревья поиска (BST) | 5 |
| 🗺 Графы: DFS и BFS | 7 |
| 🔤 Строки | 1 |

---


### 🔎 Бинарный поиск

| Задача | Сложность | Идея решения |
| --- | --- | --- |
| [704. Binary Search](https://leetcode.com/problems/binary-search/) | 🟢 Easy | Держим границы `left` и `right`, смотрим на середину и каждый раз отбрасываем ту половину, где искомого числа точно нет. |
| [35. Search Insert Position](https://leetcode.com/problems/search-insert-position/) | 🟢 Easy | Тот же бинарный поиск. Если числа нет, граница `left` в конце остаётся ровно на той позиции, куда его нужно вставить. |
| [278. First Bad Version](https://leetcode.com/problems/first-bad-version/) | 🟢 Easy | Бинарный поиск по номерам версий: если середина плохая, первая плохая версия слева (включая её), иначе справа. |

### 👉 Два указателя

Код по теме: `src/TwoPointers.java`

| Задача | Сложность | Идея решения |
| --- | --- | --- |
| [977. Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/) | 🟢 Easy | Самые большие квадраты стоят по краям массива (из-за отрицательных чисел). Идём указателями с обоих концов, большее из двух значений кладём в результат с конца. |
| [167. Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | 🟡 Medium | Массив отсортирован, поэтому ставим указатели по краям: сумма больше цели, двигаем правый влево, меньше, двигаем левый вправо. |
| [125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) | 🟢 Easy | Оставляем в строке только буквы и цифры в нижнем регистре и сравниваем символы с двух концов, сдвигаясь к центру. |
| [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/) | 🟡 Medium | Указатели по краям, площадь равна ширине, умноженной на меньшую высоту. Двигаем указатель у более низкой стенки, потому что только так площадь может вырасти. |
| [26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | 🟢 Easy | `fast` бежит по массиву, `slow` отмечает место для следующего уникального числа. Нашли новое значение, записали его на `slow`. |
| [27. Remove Element](https://leetcode.com/problems/remove-element/) | 🟢 Easy | `fast` перебирает массив, все значения, не равные `val`, копируются на позицию `slow`. |
| [75. Sort Colors](https://leetcode.com/problems/sort-colors/) | 🟡 Medium | Три указателя `low`, `mid`, `high` (задача про флаг Нидерландов): нули уходят влево, двойки вправо, единицы остаются посередине. Один проход. |
| [15. 3Sum](https://leetcode.com/problems/3sum/) | 🟡 Medium | Сортируем массив, фиксируем первое число, а пару к нему ищем двумя указателями, как в Two Sum II. Дубликаты пропускаем, чтобы тройки не повторялись. |

### 🪟 Скользящее окно

Код по теме: задача 3 лежит в `src/TwoPointers.java`

| Задача | Сложность | Идея решения |
| --- | --- | --- |
| [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | 🟡 Medium | Окно между `left` и `right` и HashMap «символ → последний индекс». Если символ уже есть внутри окна, сдвигаем `left` за его прошлое вхождение. Ответ, максимальная длина окна. |
| [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | 🟡 Medium | Расширяем окно правой границей и копим сумму. Пока сумма не меньше `target`, запоминаем длину и сжимаем окно слева. |
| [567. Permutation in String](https://leetcode.com/problems/permutation-in-string/) | 🟡 Medium | Окно длиной `s1` едет по `s2`. Сравниваем частоты букв в окне и в `s1`, при сдвиге обновляем счётчики только для вышедшего и вошедшего символов. |

### 🗃 Хэш-таблицы

Код по теме: `src/hash.java`

| Задача | Сложность | Идея решения |
| --- | --- | --- |
| [1. Two Sum](https://leetcode.com/problems/two-sum/) | 🟢 Easy | HashMap «число → индекс». Для каждого числа проверяем, видели ли мы уже `target - число`. Один проход. |
| [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) | 🟢 Easy | Складываем числа в HashSet. Если число уже есть в множестве, это дубликат. |
| [242. Valid Anagram](https://leetcode.com/problems/valid-anagram/) | 🟢 Easy | Если длины разные, это не анаграмма. Считаем частоты символов первой строки, вычитаем частоты второй, все счётчики должны обнулиться. |
| [349. Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/) | 🟢 Easy | Первый массив кладём в HashSet, идём по второму и собираем общие значения в отдельный набор, чтобы они не повторялись. |
| [350. Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/) | 🟢 Easy | HashMap с частотами чисел первого массива. Идём по второму: если счётчик числа больше нуля, добавляем число в ответ и уменьшаем счётчик. |
| [205. Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/) | 🟢 Easy | Две карты, `s → t` и `t → s`. Каждый символ должен всегда соответствовать одному и тому же символу в обе стороны. |
| [290. Word Pattern](https://leetcode.com/problems/word-pattern/) | 🟢 Easy | То же, что и Isomorphic Strings: две карты «буква → слово» и «слово → буква». Строку разбиваем по пробелам, количество слов должно совпасть с длиной шаблона. |
| [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/) | 🟡 Medium | Ключ группы, слово с отсортированными буквами. Анаграммы дают одинаковый ключ и попадают в один список HashMap. |
| [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | 🟡 Medium | Все числа в HashSet. Отсчёт ведём только от чисел, у которых нет соседа `num - 1` (начало последовательности), и идём вверх, пока числа есть. Получается O(n) без сортировки. |

### 📚 Стеки и очереди

Код по теме: `src/Stack.java`, `src/MyStack.java`, `src/MyQueue.java`

| Задача | Сложность | Идея решения |
| --- | --- | --- |
| [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) | 🟢 Easy | Открывающие скобки кладём в стек, на закрывающей сверяем её с верхушкой стека. В конце стек должен быть пустым. |
| [682. Baseball Game](https://leetcode.com/problems/baseball-game/) | 🟢 Easy | Стек очков: число кладём, `+` складывает два последних, `D` удваивает последнее, `C` убирает последнее. Ответ, сумма всего стека. |
| [844. Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/) | 🟢 Easy | Каждую строку прогоняем через стек: символ добавляем, `#` убирает верхний. Затем сравниваем получившиеся стеки. |
| [225. Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/) | 🟢 Easy | Две очереди. При `push` новый элемент кладём в пустую очередь, за ним переливаем все старые и меняем очереди местами. Новый элемент оказывается впереди, как в стеке. |
| [232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/) | 🟢 Easy | Два стека: в `in` пишем, из `out` читаем. Когда `out` опустел, перекладываем в него всё из `in`, и порядок элементов разворачивается. |

### 🔗 Связные списки

| Задача | Сложность | Идея решения |
| --- | --- | --- |
| [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | 🟢 Easy | Идём по списку и разворачиваем `next` у каждого узла назад, держим три указателя: `prev`, `curr`, `next`. |
| [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/) | 🟢 Easy | Медленный указатель делает 1 шаг, быстрый 2. Когда быстрый дошёл до конца, медленный стоит в середине. |
| [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) | 🟢 Easy | Фиктивная голова и два указателя по спискам: каждый раз присоединяем меньший узел. В конце цепляем остаток непустого списка. |
| [234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | 🟢 Easy | Находим середину (медленный и быстрый указатель), разворачиваем вторую половину и сравниваем её с первой. |
| [203. Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/) | 🟢 Easy | Фиктивный узел перед головой: если следующий узел равен `val`, перепрыгиваем его. Так удаляется и первый элемент без особых случаев. |

### 🌳 Деревья поиска (BST)

Код по теме: `src/BST.java`, `src/TreeNode.java`

| Задача | Сложность | Идея решения |
| --- | --- | --- |
| [700. Search in a Binary Search Tree](https://leetcode.com/problems/search-in-a-binary-search-tree/) | 🟢 Easy | Если значение меньше корня, идём влево, больше, вправо, равно, нашли. |
| [701. Insert into a Binary Search Tree](https://leetcode.com/problems/insert-into-a-binary-search-tree/) | 🟡 Medium | Спускаемся так же, как при поиске, а на первом пустом месте создаём новый узел. Рекурсивно возвращаем корень. |
| [938. Range Sum of BST](https://leetcode.com/problems/range-sum-of-bst/) | 🟢 Easy | Обход с отсечением: влево идём, только если корень больше `low`, вправо, только если меньше `high`. Суммируем значения из диапазона. |
| [235. Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) | 🟡 Medium | Если оба значения меньше корня, идём влево, если оба больше, вправо. Иначе пути расходятся, и текущий узел и есть предок. |
| [530. Minimum Absolute Difference in BST](https://leetcode.com/problems/minimum-absolute-difference-in-bst/) | 🟢 Easy | Собираем все значения дерева, сортируем и берём минимальную разницу между соседними. |

### 🗺 Графы: DFS и BFS

Код по теме: `src/DFSBFS.java`

| Задача | Сложность | Идея решения |
| --- | --- | --- |
| [1971. Find if Path Exists in Graph](https://leetcode.com/problems/find-if-path-exists-in-graph/) | 🟢 Easy | Строим список смежности из рёбер и обходим граф от `source` (DFS или BFS) с массивом `visited`. Дошли до `destination`, значит, путь есть. |
| [733. Flood Fill](https://leetcode.com/problems/flood-fill/) | 🟢 Easy | DFS от стартовой клетки: перекрашиваем соседей старого цвета во все четыре стороны. Если новый цвет совпадает со старым, сразу возвращаем картинку. |
| [200. Number of Islands](https://leetcode.com/problems/number-of-islands/) | 🟡 Medium | Идём по сетке. Нашли `1`, увеличиваем счётчик и DFS-ом «топим» весь остров (ставим `0`), чтобы не посчитать его снова. |
| [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/) | 🟡 Medium | Тот же обход, но DFS возвращает размер острова, а мы берём максимум. |
| [547. Number of Provinces](https://leetcode.com/problems/number-of-provinces/) | 🟡 Medium | DFS по матрице смежности. Для каждого ещё не посещённого города запускаем обход и увеличиваем счётчик, то есть считаем компоненты связности. |
| [841. Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/) | 🟡 Medium | DFS из комнаты 0: в каждой комнате берём ключи и идём в новые комнаты. В конце проверяем, что посещены все. |
| [994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) | 🟡 Medium | BFS с несколькими стартами: все гнилые апельсины сразу в очередь, один уровень обхода равен одной минуте. Считаем свежие, если после обхода они остались, ответ -1. |

### 🔤 Строки

| Задача | Сложность | Идея решения |
| --- | --- | --- |
| [28. Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/) | 🟢 Easy | Сдвигаем окно длиной `needle` по `haystack` и сравниваем подстроку с `needle`. Первое совпадение даёт индекс, иначе -1. |

---

## 🧩 Не только LeetCode

Кроме задач, в репозитории есть учебные реализации классических алгоритмов и структур данных:

| Файл | Что внутри |
| --- | --- |
| `src/sorts.java` | Сортировка вставками и быстрая сортировка (QuickSort) |
| `src/Di4.java` | Поиск кратчайших путей: алгоритм Дейкстры (с приоритетной очередью) и Беллмана-Форда |
| `src/Main.java` | Мин-куча (`Minheap`) на массиве: добавление, просмотр корня, удаление минимума |
| `src/MyStack.java`, `src/MyQueue.java` | Стек на двух очередях и очередь на двух стеках |

---

## 🗂 Структура проекта

```
Teach/
└── src/
    ├── TwoPointers.java    # два указателя и скользящее окно
    ├── hash.java           # хэш-таблицы
    ├── Stack.java          # задачи на стек
    ├── MyStack.java        # стек на очередях
    ├── MyQueue.java        # очередь на стеках
    ├── BST.java            # деревья поиска
    ├── TreeNode.java       # узел бинарного дерева
    ├── DFSBFS.java         # графы: обходы в глубину и ширину
    ├── Di4.java            # Дейкстра и Беллман-Форд
    ├── sorts.java          # сортировки
    └── Main.java           # мин-куча и точка входа
```

## 👤 Автор

[@isro456](https://github.com/isro456)
