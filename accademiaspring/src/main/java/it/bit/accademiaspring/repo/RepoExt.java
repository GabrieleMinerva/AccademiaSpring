package it.bit.accademiaspring.repo;

import it.bit.accademiaspring.model.Student;

public interface RepoExt<T> {
	void patch(T element);
}
