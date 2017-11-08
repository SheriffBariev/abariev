package ru.job4j.encapsulation;
/**
 * Class Item.
 */
public class Item {
	/**
	 * Приватная строка id.
	 */
	private String id;
	/**
	 * Приватная строка name.
	 */
	private String name;
	/**
	 * Приватная строка desc.
	 */
	private String desc;
	/**
	 * Приватная переменная create.
	 */
	private long create;
	/**
	* Доступ по умолчанию - комментарий.
	*/
	String[] comments;
	/**
	* Конструктор по умолчанию.	
	*/
	public Item() {
}	
	/**
	* Конструктор c тремя входными значениями.
	* @param name имя.
	* @param desc описание.
	* @param create создано.
	*/
	public Item(String name, String desc, long create) {
	this.name = name;
	this.desc = desc;
	this.create = create;
}	
	/**
	* Геттер.
	* @return имя.
	*/
	public String getName() {
	return this.name;
}	
	/**
	* геттер.
	* @return описание.
	*/
	public String getDesc() {
	return this.desc;
}	
	/**
	* геттер.
	* @return создано.
	*/
	public long getCreate() {
	return this.create;
}	
	/**
	* геттер.
	* @return id.
	*/
	public String getId() {
	return this.id;
}	
	/**
	* геттер.
	* @return создано.
	*/
	public void setId(String id) {
	this.id = id;
}	
}