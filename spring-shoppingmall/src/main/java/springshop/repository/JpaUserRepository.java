package springshop.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import springshop.domain.Users;


public class JpaUserRepository implements UserRepository {

	private final EntityManager em;

	public JpaUserRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public Users save(Users users) {
		// TODO Auto-generated method stub
		em.persist(users);
		return users;
	}

	@Override
	public Optional<Users> findById(Long usernum) {
		// TODO Auto-generated method stub
		Users users = em.find(Users.class, usernum);
		return Optional.ofNullable(users);
	}

	@Override
	public Optional<Users> findByName(String username) {
		// TODO Auto-generated method stub
		List<Users> result = em.createQuery("select m from Users m where m.username = :username", Users.class)
				.setParameter("username", username).getResultList();
		return result.stream().findAny();
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select m from Users m", Users.class).getResultList();
	}

}
